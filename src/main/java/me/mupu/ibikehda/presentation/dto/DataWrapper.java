package me.mupu.ibikehda.presentation.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
public class DataWrapper implements Serializable {

    private String cmd;

    private Object data;

}