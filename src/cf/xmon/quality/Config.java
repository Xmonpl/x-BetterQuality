package cf.xmon.quality;

import com.google.gson.annotations.SerializedName;

public class Config {
    @SerializedName("configuration")
    private Instance Instance = new Instance();
    public Config(){

    }
    public Instance getInstance(){
        return this.Instance;
    }
}
