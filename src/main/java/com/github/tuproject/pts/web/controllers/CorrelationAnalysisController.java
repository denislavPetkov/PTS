package com.github.tuproject.pts.web.controllers;

import com.github.tuproject.pts.data.entities.Student;
import com.github.tuproject.pts.data.entities.StudentActivities;
import com.github.tuproject.pts.service.DataHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.List;

@Controller
@RequestMapping("/correlationAnalysis")
public class CorrelationAnalysisController extends BaseController{

    private String studentsPath1 = "Course_A_StudentsResults_Year_1.xlsx";
    private String studentsPath2 = "Course_A_StudentsResults_Year_2.xlsx";
    private String studentActivitiesPath = "Logs_Course_A_StudentsActivities.xlsx";

    @Autowired
    DataHandler dataHandler;

    @GetMapping
    public ModelAndView mainPage(Model model) throws  FileNotFoundException {
        List<Student> students = dataHandler.GetStudents(studentsPath1);
//        students.addAll(dataHandler.GetStudents(studentsPath2));

        List <StudentActivities> studentActivities = dataHandler.GetStudentActivities(studentActivitiesPath);

        model.addAttribute("studentList" , dataHandler.SetUploadedFiles(students, studentActivities));
        model.addAttribute("correlationCoefficient", dataHandler.GetPearsonsCorrelation(students));
        return super.view("correlationAnalysis");
    }

}
