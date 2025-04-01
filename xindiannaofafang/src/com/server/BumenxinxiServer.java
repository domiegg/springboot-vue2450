package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Bumenxinxi;

public interface BumenxinxiServer {

  public int add(Bumenxinxi po);

  public int update(Bumenxinxi po);
  
  
  
  public int delete(int id);

  public List<Bumenxinxi> getAll(Map<String,Object> map);
  public List<Bumenxinxi> getsybumenxinxi1(Map<String,Object> map);
  public List<Bumenxinxi> getsybumenxinxi2(Map<String,Object> map);
  public List<Bumenxinxi> getsybumenxinxi3(Map<String,Object> map);
  public Bumenxinxi quchongBumenxinxi(Map<String, Object> acount);

  public Bumenxinxi getById( int id);

  public List<Bumenxinxi> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Bumenxinxi> select(Map<String, Object> map);
}
//	所有List
