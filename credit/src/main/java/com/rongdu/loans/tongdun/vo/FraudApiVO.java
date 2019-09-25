package com.rongdu.loans.tongdun.vo;

import com.rongdu.common.exception.ErrInfo;
import com.rongdu.loans.credit.common.CreditApiVo;
import com.rongdu.loans.tongdun.common.FraudApiRespCodeUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FraudApiVO extends CreditApiVo {
	
	private static final long serialVersionUID = 4152462611121573434L;
//	// 执行是否成功，不成功时对应reason_code
//	private boolean success = false;
	// 错误码及原因描述，正常执行完扫描时为空
	private String reason_code;
	// 风险分数
	private Integer final_score;
	// 最终的风险决策结果
	private String final_decision;
	// 策略名称
	private String policy_name;
	// 命中规则列表
	private List<HitRule> hit_rules = new ArrayList<>();
	// 请求序列号，每个请求进来都分配一个全局唯一的id
	private String seq_id;
	// 花费的时间，单位ms
	private Integer spend_time;
	// 地理位置信息
	private Map<String, String> geoip_info = new HashMap<>();
	// 设备指纹信息
	private Map<String, Object> device_info = new HashMap<>();
	// 归属地信息
	private Map<String, Object> attribution = new HashMap<>();
	// 策略集信息
	private List<Policy> policy_set = new ArrayList<>();
	// 决策结果自定义输出
	private List<Map<String, Object>> output_fields = new ArrayList<>();
	// 策略集名称
	private String policy_set_name;
	// 风险类型
	private String risk_type;

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public String getReason_code() {
		return reason_code;
	}

	public void setReason_code(String reason_code) {
		this.reason_code = reason_code;
	}

	public Integer getFinal_score() {
		return final_score;
	}

	public void setFinal_score(Integer final_score) {
		this.final_score = final_score;
	}

	public String getFinal_decision() {
		return final_decision;
	}

	public void setFinal_decision(String final_decision) {
		this.final_decision = final_decision;
	}

	public String getPolicy_name() {
		return policy_name;
	}

	public void setPolicy_name(String policy_name) {
		this.policy_name = policy_name;
	}

	public List<HitRule> getHit_rules() {
		return hit_rules;
	}

	public void setHit_rules(List<HitRule> hit_rules) {
		this.hit_rules = hit_rules;
	}

	public String getSeq_id() {
		return seq_id;
	}

	public void setSeq_id(String seq_id) {
		this.seq_id = seq_id;
	}

	public Integer getSpend_time() {
		return spend_time;
	}

	public void setSpend_time(Integer spend_time) {
		this.spend_time = spend_time;
	}

	public Map<String, String> getGeoip_info() {
		return geoip_info;
	}

	public void setGeoip_info(Map<String, String> geoip_info) {
		this.geoip_info = geoip_info;
	}

	public Map<String, Object> getDevice_info() {
		return device_info;
	}

	public void setDevice_info(Map<String, Object> device_info) {
		this.device_info = device_info;
	}

	public Map<String, Object> getAttribution() {
		return attribution;
	}

	public void setAttribution(Map<String, Object> attribution) {
		this.attribution = attribution;
	}

	public List<Policy> getPolicy_set() {
		return policy_set;
	}

	public void setPolicy_set(List<Policy> policy_set) {
		this.policy_set = policy_set;
	}

	public List<Map<String, Object>> getOutput_fields() {
		return output_fields;
	}

	public void setOutput_fields(List<Map<String, Object>> output_fields) {
		this.output_fields = output_fields;
	}

	public String getPolicy_set_name() {
		return policy_set_name;
	}

	public void setPolicy_set_name(String policy_set_name) {
		this.policy_set_name = policy_set_name;
	}

	public String getRisk_type() {
		return risk_type;
	}

	public void setRisk_type(String risk_type) {
		this.risk_type = risk_type;
	}


	@Override
	public String toString() {
		return "FraudApiResponse [success=" + success + ", reason_code="
				+ reason_code + ", final_score=" + final_score
				+ ", final_decision=" + final_decision + ", policy_name="
				+ policy_name + ", seq_id=" + seq_id + ", spend_time="
				+ spend_time + ", policy_set_name=" + policy_set_name
				+ ", risk_type=" + risk_type + "]";
	}

	@Override
	public boolean isSuccess() {
		return this.success;
	}

	@Override
	public void setSuccess(boolean success) {
		this.success = success;
	}

	@Override
	public String getCode() {
		if (isSuccess()){
			return ErrInfo.SUCCESS.getCode();
		}else{
			return getReason_code();
		}
	}

	@Override
	public void setCode(String code) {

	}

	@Override
	public String getMsg() {
		return FraudApiRespCodeUtils.getApiMsg(getReason_code());
	}

	@Override
	public void setMsg(String msg) {

	}
}
