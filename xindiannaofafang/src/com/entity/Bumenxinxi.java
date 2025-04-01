package com.entity;

public class Bumenxinxi {
    private Integer id;
	private String bumen;	
    private String addtime;

    

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
	
	public String getBumen() {
        return bumen;
    }
    public void setBumen(String bumen) {
        this.bumen = bumen == null ? null : bumen.trim();
    }	
	
	
    public String getAddtime() {
        return addtime;
    }
    public void setAddtime(String addtime) {
        this.addtime = addtime == null ? null : addtime.trim();
    }
}
//   设置字段信息
