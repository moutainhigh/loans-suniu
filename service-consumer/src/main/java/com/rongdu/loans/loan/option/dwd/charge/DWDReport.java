package com.rongdu.loans.loan.option.dwd.charge;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.rongdu.loans.loan.option.jdq.JDQUrgentContact;
import com.rongdu.loans.loan.option.jdq.report.Calincntlistv;
import com.rongdu.loans.loan.option.jdq.report.Calloutcntlistv;
import com.rongdu.loans.loan.option.xjbk.ContactCheck;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * Auto-generated: 2018-10-24 9:35:34
 *
 * @author www.jsons.cn 
 * @website http://www.jsons.cn/json2java/ 
 */
@Data
public class DWDReport implements Serializable {

    private static final long serialVersionUID = -7000198665595215225L;
    private int call110;
    private Basic basic;
    @JsonProperty("callAtNight")
    private int callatnight;
    @JsonProperty("contactRegionsV")
    private String contactregionsv;
    @JsonProperty("urgentContact")
    private List<JDQUrgentContact> urgentcontact;
    @JsonProperty("countCall")
    private int countcall;
    private BigDecimal bl;
    private int zjsize;
    private List<Transaction> transactions;
    private int bjsize;
    @JsonProperty("callOutCntListV")
    private List<Calloutcntlistv> calloutcntlistv;
    private int days3;
    private int month3Days;
    private int month;
    private int days1;
    private int days;
    @JsonProperty("bigDecimal")
    private BigDecimal bigdecimal;
    @JsonProperty("calInCntListV")
    private List<Calincntlistv> calincntlistv;
    @JsonProperty("gpsAddress1")
    private String gpsaddress1;
    private List<ContactCheck> contactCheckList;

    private String channelCode;
    private String recentDays3Time;


}