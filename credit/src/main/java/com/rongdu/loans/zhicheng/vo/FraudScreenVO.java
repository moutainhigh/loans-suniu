package com.rongdu.loans.zhicheng.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author fy
 * @Package com.rongdu.loans.zhicheng.vo
 * @date 2019/7/5 10:18
 */
@Data
public class FraudScreenVO implements Serializable {

    private String code;
    private String msg;
    private FraudDetail data;
    private String flowId;
    private Boolean success;
}
