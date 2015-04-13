package in.credit.servlets;

import in.credit.U;
import in.credit.bao.CityBao;
import in.credit.bao.CityViewModel;
import in.credit.bao.StateBao;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Team
 */
@WebServlet(name = "CityServlet", urlPatterns = {"/admin/city"})
public class CityServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("model", new CityViewModel());
        request.setAttribute("states", StateBao.gets());
        request.setAttribute("cities", CityBao.gets());
        request.getRequestDispatcher("/WEB-INF/pages/city.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /* Models */
        CityViewModel model = new CityViewModel();
        String message = "";
        
        /* Read request params */
        model.setCityId(U.paramInt(request, "cityId"));
        model.setCityName(U.param(request, "cityName"));
        model.setStateId(U.paramInt(request, "stateId"));
        model.setStateName(U.param(request, "stateName"));
        String cmd = U.param(request, "cmd");
        
        /* Actions */
        if("AddState".equals(cmd )){
            message = StateBao.add(model) ? "State added successfully": "Duplicate state. Reenter please.";
        }
        if("UpdateState".equals(cmd)) {
            message = StateBao.update(model) ? "State updated successfully": "Cannot update state";
        }
        if("DeleteState".equals(cmd)) {
            message = StateBao.delete(model) ? "State deleted successfully": "Cannot delete state";
            model=new CityViewModel();
        }
        if("ClearState".equals(cmd)) {
           model=new CityViewModel();
        }
        
        if("AddCity".equals(cmd)){
             message = CityBao.add(model) ? "City added successfully": "Duplicate city. Reenter please.";
        }
        if("UpdateCity".equals(cmd)){
             message = CityBao.update(model) ? "City updated successfully": "Cannot update city name";
        }
        if("DeleteCity".equals(cmd)){
             message = CityBao.delete(model) ? "City deleted successfully": "Cannot delete city.";
             model=new CityViewModel();
        }
        if("ClearCity".equals(cmd)){
             model=new CityViewModel();
        }
        
            
        /* Push models */
         if(model.getCityId()!=0) {
            model = CityBao.get(model);
        }else
        if(model.getStateId()!=0) {
            model = StateBao.get(model);
        }
       
        request.setAttribute("message", message);
        request.setAttribute("states", StateBao.gets());
        request.setAttribute("cities", CityBao.getCitiesOfState(model));
        request.setAttribute("model", model);
        System.out.println(model.getStateId() + " " + model.getStateName());
        request.getRequestDispatcher("/WEB-INF/pages/city.jsp").forward(request, response);
    }

}
