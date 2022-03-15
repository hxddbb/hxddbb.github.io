package com.hxddbb.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Activeueser {
    private String username;//前端的属性封装成对象便于接受
    private String password;
    @JsonProperty("certId")//这里属性名和前端的name值不一样，改属性名很麻烦，牵扯到很多地方，直接加注释
    private String sfzid;

}
