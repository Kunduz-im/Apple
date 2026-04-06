package org.example.gorest.models;


import org.example.gorest.JsonUtils;

public abstract class BaseModel {

    public String toJSON (){
        return JsonUtils.toJson(this);
    }
}
