package ir.mctab.java32.projects.scholarshipmanagement.features.scholarshipverification.impl;

import ir.mctab.java32.projects.scholarshipmanagement.core.annotations.Service;
import ir.mctab.java32.projects.scholarshipmanagement.core.annotations.UseCase;
import ir.mctab.java32.projects.scholarshipmanagement.core.config.DatabaseConfig;
import ir.mctab.java32.projects.scholarshipmanagement.core.share.AuthenticationService;
import ir.mctab.java32.projects.scholarshipmanagement.features.scholarshipverification.usecases.AcceptScholarshipBySupervisorUsecase;
import ir.mctab.java32.projects.scholarshipmanagement.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Service
public class AcceptScholarshipBySupervisorUseCaseImpl implements AcceptScholarshipBySupervisorUsecase
{
    public void accept(long scholarshipId) {
        User loginUser = AuthenticationService.getInstance().getLoginUser();
        if(loginUser != null && loginUser.getRole().equals("supervisor")){
            //connection
            try {
                Connection connection = DatabaseConfig.getDatabaseConnection();
                //sql
                String sql = "update scholarship set status = 'AcceptedBySupervisor' " + "where id = ?" ;
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
