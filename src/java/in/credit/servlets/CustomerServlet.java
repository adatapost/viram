package in.credit.servlets;

import in.credit.U;
import in.credit.bao.AccountBao;
import in.credit.bao.AccountTypeBao;
import in.credit.bao.AccountTypeViewModel;
import in.credit.bao.AccountViewModel;
import in.credit.bao.CityBao;
import in.credit.bao.CityViewModel;
import in.credit.bao.LedgerBao;
import in.credit.bao.LedgerViewModel;
import in.credit.bao.StateBao;
import in.credit.bao.UserAccountBao;
import in.credit.bao.UserAccountViewModel;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author Vir@m
 */
@MultipartConfig()
@WebServlet(name = "CustomerServlet", urlPatterns = {"/admin/customer","/employee/customer"})
public class CustomerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("states", StateBao.gets());
        request.setAttribute("cities", CityBao.gets());
        request.setAttribute("accTypes", AccountTypeBao.gets());
        request.setAttribute("accounts", AccountBao.gets());
        request.setAttribute("refAccounts", AccountBao.gets());
        request.setAttribute("account", new AccountViewModel());
        request.getRequestDispatcher("/WEB-INF/pages/customer.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String message = "";
        String fileName = "/WEB-INF/pages/customer.jsp";
        AccountViewModel model = new AccountViewModel();
        String cmd = U.param(request, "cmd");
        model.setUserId(U.paramInt(request, "userId"));
        model.setAddress(U.param(request, "address"));
        model.setBirthDate(U.paramDate(request, "birthDate"));
        model.setCityId(U.paramInt(request, "cityId"));
        model.setCreated(U.now());
        model.setCreatedByUserId(U.userId(request));
        model.setCustImg(U.param(request, "custImg"));
        model.setFirstName(U.param(request, "firstName"));
        model.setMiddleName(U.param(request, "middleName"));
        model.setLastName(U.param(request, "lastName"));
        model.setGender(U.param(request, "gender"));
        model.setIsDeleted(U.paramBool(request, "isDeleted"));
        model.setPhone(U.param(request, "phone"));
        model.setReferenceUserId(U.paramInt(request, "referenceUserId"));
        model.setRoleId(3);
        model.setStateId(U.paramInt(request, "stateId"));
        model.setTypeId(U.paramInt(request, "typeId"));
        model.setUserEmail(U.param(request, "userEmail"));
        model.setUserPass(U.param(request, "userPass"));
        
        model.setNoBirthDate(U.paramDate(request, "noBirthDate"));
        model.setNoFirstName(U.param(request, "noFirstName"));
        model.setNoGender(U.param(request, "noGender"));
        model.setNoLastName(U.param(request, "noLastName"));
        model.setNoMiddleName(U.param(request, "noMiddleName"));

        Part file = request.getPart("file");

        /* Reference Model objects  */
        UserAccountViewModel user = null;
        AccountViewModel acc = null;
        LedgerViewModel ledger = null;
        AccountTypeViewModel type=AccountTypeBao.get(new AccountTypeViewModel(model.getTypeId()));
        
        if ("Update account".equals(cmd)) {
            if (U.saveImage(file, U.PATH_CUSTOMER + model.getUserId()));
            AccountBao.update(model);
            request.setAttribute("isFound", true);
        }

        if ("Add".equals(cmd)) {
            user = new UserAccountViewModel();
            user.setUserEmail(model.getUserEmail());
            user.setUserPass(model.getUserPass());
            user.setRoleId(model.getRoleId());
            user.setCreated(model.getCreated());
            user.setIsActivate(Boolean.TRUE);
            user.setIsDeleted(Boolean.FALSE);

            if (UserAccountBao.add(user)) {
                System.out.println(user.getUserId());
                if (U.saveImage(file, U.PATH_CUSTOMER + user.getUserId()));
                acc = new AccountViewModel();
                acc.setCustImg(user.getUserId()+"");
                acc.setUserId(user.getUserId());
               
                acc.setTypeId(model.getTypeId());
                acc.setAddress(model.getAddress());
                acc.setBirthDate(model.getBirthDate());
                
                acc.setCityId(model.getCityId());
                acc.setCreated(model.getCreated());
                acc.setFirstName(model.getFirstName());
                acc.setMiddleName(model.getMiddleName());
                acc.setLastName(model.getLastName());
                acc.setGender(model.getGender());
                acc.setIsDeleted(model.getIsDeleted());
                acc.setPhone(model.getPhone());
                acc.setReferenceUserId(model.getReferenceUserId());
                acc.setCreatedByUserId(U.userId(request));
                acc.setNoBirthDate(model.getNoBirthDate());
                acc.setNoFirstName(model.getNoFirstName());
                acc.setNoGender(model.getNoGender());
                acc.setNoLastName(model.getNoLastName());
                acc.setNoMiddleName(model.getNoMiddleName());

                AccountBao.add(acc);

                /*  Create ledger  */
                ledger = new LedgerViewModel();
                ledger.setAccountId(user.getUserId());
                ledger.setCreated(U.now());
                ledger.setCurrentAcYear(U.now().getYear() + 1900);
                ledger.setIsClosed(false);
                ledger.setIsDeleted(false);
                ledger.setLedgerName(acc.getFirstName() + " " 
                        + acc.getMiddleName() + " " 
                        + acc.getLastName() + " "
                        + type.getTypeName() + " A/C" );
                ledger.setLedgerTypeId(2);//2 for liabilities

                LedgerBao.add(ledger);

                message = "Account created successfully";
            } else {
                message = "Error in fields.";
            }
        }

        if ("Edit".equals(cmd)) {
            model = AccountBao.getAccount(model.getUserId());
            request.setAttribute("isFound", true);
        }
        if ("X".equals(cmd)) {
            if (AccountBao.delete(new AccountViewModel(model.getUserId()))
                    && UserAccountBao.delete(model.getUserId())) {
                message = "Deleted Successfully...";
                fileName = "Customer?action=showCust";
            } else {
                  message = "Can't Deleted... It is referenced.";
            }
        }
        
        if(model.getUserId()!=0 ){
            model=AccountBao.get(model);
        }
        request.setAttribute("states", StateBao.gets());
        request.setAttribute("accTypes", AccountTypeBao.gets());
        request.setAttribute("refAccounts", AccountBao.gets());
        request.setAttribute("accounts", AccountBao.getAccountsByAccType(model.getTypeId()));
        request.setAttribute("account", model);
        request.setAttribute("ledgers", LedgerBao.getLedgersByAccountId(model.getUserId()));
        request.setAttribute("cities", CityBao.getCitiesOfState(new CityViewModel(0,"",model.getStateId(),"")));
        request.setAttribute("message", message);
        request.getRequestDispatcher(fileName)
                .forward(request, response);
    }

}
