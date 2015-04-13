package in.credit.bao;

 
public class CityViewModel {
    private int cityId;
    private String cityName;
    private int stateId;
    private String stateName;

    public CityViewModel() {
    }

    public CityViewModel(int cityId, String cityName, int stateId, String stateName) {
        this.cityId = cityId;
        this.cityName = cityName;
        this.stateId = stateId;
        this.stateName = stateName;
    }

    public CityViewModel(int cityId) {
        this.cityId = cityId;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public int getStateId() {
        return stateId;
    }

    public void setStateId(int stateId) {
        this.stateId = stateId;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }
    
}
