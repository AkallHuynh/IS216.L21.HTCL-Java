/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.TieuDungDAL;
import DTO.TieuDungDTO;
import java.util.ArrayList;

/**
 *
 * @author huynh
 */
public class TieuDungBLL {
    TieuDungDAL tieuDungDal = new TieuDungDAL();
    public ArrayList<TieuDungDTO> getAllChiTieu(){
        return tieuDungDal.getAlltieudung();
    }
    public TieuDungDTO getTieuDungById(String maTieuDung){
        return tieuDungDal.getTieuDungById(maTieuDung);
    }
    public ArrayList<TieuDungDTO> getAllTieuDungByMaChiTieu(String machitieu){
        return tieuDungDal.getAllTieuDungByMaChiTieu(machitieu);
    }
}
