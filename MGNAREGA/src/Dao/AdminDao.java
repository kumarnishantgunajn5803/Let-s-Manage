package Dao;

import Exception.BdoException;
import Model.BDO;

public interface AdminDao {
  public String addBdo(BDO b) throws BdoException;
} 
