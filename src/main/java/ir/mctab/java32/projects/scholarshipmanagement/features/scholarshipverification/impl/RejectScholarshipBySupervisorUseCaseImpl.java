package ir.mctab.java32.projects.scholarshipmanagement.features.scholarshipverification.impl;

import ir.mctab.java32.projects.scholarshipmanagement.core.annotations.Service;
import ir.mctab.java32.projects.scholarshipmanagement.core.annotations.UseCase;
import ir.mctab.java32.projects.scholarshipmanagement.core.config.DatabaseConfig;
import ir.mctab.java32.projects.scholarshipmanagement.core.share.AuthenticationService;
import ir.mctab.java32.projects.scholarshipmanagement.features.scholarshipverification.usecases.RejectScholarshipBySupervisorUseCase;
import ir.mctab.java32.projects.scholarshipmanagement.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Service
public class RejectScholarshipBySupervisorUseCaseImpl implements RejectScholarshipBySupervisorUseCase {
   public void reject (long scholarshipId){
       User user = AuthenticationService.getInstance().getLoginUser();
       if(user != null && user.getRole().equals("supervisor")){
           Connection connection = null;
           try {
               connection = DatabaseConfig.getDatabaseConnection();
               //sql
               String sql = "update scholarship set status = 'RejectedBySupervisor' + where id = ?";
               PreparedStatement preparedStatement = connection.prepareStatement(sql);
               preparedStatement.setLong(1,scholarshipId);
               preparedStatement.executeUpdate();
           } catch (ClassNotFoundException e) {
               e.printStackTrace();
           } catch (SQLException e) {
               e.printStackTrace();
           }

       }
   }

}
