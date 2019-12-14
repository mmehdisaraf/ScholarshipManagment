package ir.mctab.java32.projects.scholarshipmanagement;

import ir.mctab.java32.projects.scholarshipmanagement.features.scholarshipverification.impl.*;
import ir.mctab.java32.projects.scholarshipmanagement.features.scholarshipverification.usecases.*;
import ir.mctab.java32.projects.scholarshipmanagement.features.usermanagement.impl.LoginUseCaseImpl;
import ir.mctab.java32.projects.scholarshipmanagement.features.usermanagement.usecases.LoginUseCase;
import ir.mctab.java32.projects.scholarshipmanagement.model.Scholarship;
import ir.mctab.java32.projects.scholarshipmanagement.model.User;

import java.util.List;
import java.util.Scanner;

public class ScholarshipManagementApplication {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String command = "";
        while (! command.equals("exit")) {
            System.out.println("what do you want? ");
            command = scanner.nextLine();
            // Login
            if (command.equals("login")) {
                System.out.println("Username : ");
                String username = scanner.nextLine();
                System.out.println("Password : ");
                String password = scanner.nextLine();
                LoginUseCase loginUseCase = new LoginUseCaseImpl();
                User user = loginUseCase.login(username, password);
                if (user != null) {
                    System.out.println(" Login successful by " + user.getRole());
                }
            }
            if (command.equals("dashboard")){
                DashboardStudentUseCase dashboardStudentUseCase =
                        new DashboardStudentUseCaseImpl();
                List<Scholarship> scholarship = dashboardStudentUseCase
                        .listScholarships();
                for (int i = 0; i < scholarship.size(); i++) {
                    System.out.println(scholarship.get(i));}
            }
            //
            if (command.equals("request")){
                RequestScholarshipByStudentUseCase requestScholarshipByStudentUseCase
                        = new RequestScholarshipByStudentUseCaseImpl();
                Scanner scanner1 = new Scanner(System.in);
                System.out.println("Please enter your name:");
                String name = scanner1.nextLine();
                System.out.println("Please enter your last_name:");
                String family = scanner1.nextLine();
                System.out.println("Please enter your nationalCode:");
                String natinalCode = scanner1.nextLine();
                System.out.println("Please enter your lastUni:");
                String lastuni = scanner1.nextLine();
                System.out.println("Please enter your lastDegree:");
                String lastdegree = scanner1.nextLine();
                System.out.println("Please enter your lastField:");
                String lastfield = scanner1.nextLine();
                System.out.println("Please enter your lastScore:");
                Float score = scanner1.nextFloat();
                String aaaaa = scanner1.nextLine();
                System.out.println("Please enter your applyUni:");
                String applyuni = scanner1.nextLine();
                System.out.println("Please enter your applyDegree:");
                String applydegree = scanner1.nextLine();
                System.out.println("Please enter your applyField:");
                String applyfield = scanner1.nextLine();
                System.out.println("Please enter your applyDate:");
                String applydate = scanner1.nextLine();
                requestScholarshipByStudentUseCase.request(name,family,natinalCode,lastuni,lastdegree,lastfield,score,applyuni,applydegree,applyfield,applydate);

            }
            // find scholarship by supervisor
            if (command.equals("svlist")) {
                FindScholarshipBySupervisorUseCase findScholarshipBySupervisorUseCase
                        = new FindScholarshipBySupervisorUseCaseImpl();

                List<Scholarship> scholarships = findScholarshipBySupervisorUseCase
                        .listScholarships();
                for (int i = 0; i < scholarships.size(); i++) {
                    System.out.println(scholarships.get(i));
                }
            }
            if (command.equals("svaccept")){
                AcceptScholarshipBySupervisorUsecase acceptScholarshipBySupervisorUsecase =
                        new AcceptScholarshipBySupervisorUseCaseImpl();
                System.out.println("scholarship Id: ");
                String scholarshipId = scanner.nextLine();
                acceptScholarshipBySupervisorUsecase.accept(Long.parseLong(scholarshipId));
                System.out.println("Done.");
            }
            if (command.equals("screject")){
                RejectScholarshipBySupervisorUseCase rejectScholarshipBySupervisorUseCase =
                        new RejectScholarshipBySupervisorUseCaseImpl();
                System.out.println("scholarship Id: ");
                String scholarshipId = scanner.nextLine();
                rejectScholarshipBySupervisorUseCase.reject(Long.parseLong(scholarshipId));
                System.out.println("Done.");
            }
            if (command.equals("mnlist")) {
                FindScholarshipByManagerUseCase findScholarshipByManagerUseCase
                        = new FindScholarshipByManagerUseCaseImpl();

                List<Scholarship> scholarships = findScholarshipByManagerUseCase
                        .listScholarships();
                for (int i = 0; i < scholarships.size(); i++) {
                    System.out.println(scholarships.get(i));
                }
            }
            if (command.equals("mnaccept")){
                AcceptScholarshipByManagerUseCase acceptScholarshipByManagerUseCase =
                        new AcceptScholarshipByManagerUseCaseImpl();
                System.out.println("scholarship Id: ");
                String scholarshipId = scanner.nextLine();
                acceptScholarshipByManagerUseCase.accept(Long.parseLong(scholarshipId));
                System.out.println("Done.");
            }
            if (command.equals("mnreject")){
                RejectScholarshipByManagerUseCase rejectScholarshipByManagerUseCase =
                        new RejectScholarshipByManagerUseCaseImpl();
                System.out.println("scholarship Id: ");
                String scholarshipId = scanner.nextLine();
                rejectScholarshipByManagerUseCase.reject(Long.parseLong(scholarshipId));
                System.out.println("Done.");
            }
            if (command.equals("unilist")){
                FindScholarshipByUniversityUseCase findScholarshipByUniversityUseCase =
                        new FindScholarshipByUniversityUseCaseImpl();
                List<Scholarship> scholarships = findScholarshipByUniversityUseCase
                        .listScholarships();
                for (int i = 0; i < scholarships.size(); i++) {
                    System.out.println(scholarships.get(i));

            }
        }
    }
}
}
