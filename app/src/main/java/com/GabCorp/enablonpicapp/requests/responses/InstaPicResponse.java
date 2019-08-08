package com.GabCorp.enablonpicapp.requests.responses;

import com.GabCorp.enablonpicapp.models.InstaPic;
import com.google.gson.annotations.SerializedName;

/**
 * Contains the response from which the datas will be extracted
 */
public class InstaPicResponse {

    @SerializedName("data")
    private InstaPic instaPic;

    public InstaPic getInstaPic() {
        return instaPic;
    }

    @Override
    public String toString() {
        return "InstaPicResponse{" +
                "instaPic=" + instaPic +
                '}';
    }
}
