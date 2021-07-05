/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;
import DTO.User;
import DAL.UserDAL;
/**
 *
 * @author dangk
 */
public class UserBLL {
    UserDAL userDAL = new UserDAL();
    public UserBLL(){}
    
    public boolean userValidate(User user){
        User validate = userDAL.getUserByID(user);
        if (validate == null)
            return false;
        else             
            return validate.getPassword().equals(user.getPassword());
    }
    public int insertUser(User user){
        return this.userDAL.insertUser(user);
    }
    public int updateMatKhau(User user){
        return this.userDAL.updatePassword(user);
    }
}
