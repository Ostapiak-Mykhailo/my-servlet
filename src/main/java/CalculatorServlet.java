import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;

@WebServlet("/onlineCalculator")
public class CalculatorServlet extends HttpServlet {
    Calculator calculator = new Calculator();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        response.setContentType("text/html");
        try (PrintWriter writer = response.getWriter()) {
            writer.println("<h2>Hello from my servlet</h2>");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        DecimalFormat df = new DecimalFormat("0.##");
        response.setContentType("text/html");

        String option = request.getParameter("option");
        String firstNumber = request.getParameter("firstnumber");
        String secondNumber = request.getParameter("secondnumber");
        double result = calculator.findResult(option, firstNumber, secondNumber);
        String formattedResult = df.format(result);

        try (PrintWriter writer = response.getWriter()) {
            writer.println("<h2>numbers: " + firstNumber + "; " + secondNumber + "</h2>");
            writer.println("<h2>Option: " + option + "</h2>");
            writer.println("<h2>Result: " + formattedResult + "</h2>");
        }
    }
}
