package servlet;

import entity.ChatMessage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MessageListServlet extends ChatServlet {
    private static final long serialVersionUID = 1L;

//    protected void doGet(HttpServletRequest request, HttpServletResponse
//            response) throws ServletException, IOException {
//// Установить кодировку HTTP-ответа UTF-8
//        response.setCharacterEncoding("utf8");
//// Получить доступ к потоку вывода HTTP-ответа
//        PrintWriter pw = response.getWriter();
//// Записть в поток HTML-разметку страницы
//        pw.println("<html><head><meta http-equiv='Content-Type' content='text/html; charset=utf-8'/><meta http-equiv='refresh' content='10'></head>");
//                pw.println("<body>");
//// В обратном порядке записать в поток HTML-разметку для каждог сообщения
//        for (int i=messages.size()-1; i>=0; i--) {
//            ChatMessage aMessage = messages.get(i);
//            pw.println("<div><strong>" + aMessage.getAuthor().getName()
//                    + "</strong>: " + aMessage.getMessage() + "</div>");
//        }
//        pw.println("</body></html>");
//    }
protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    // Установить правильную кодировку и тип контента
    response.setContentType("text/html; charset=UTF-8");
    response.setCharacterEncoding("UTF-8");

    // Получить поток вывода HTTP-ответа
    PrintWriter pw = response.getWriter();

    // Записать HTML-разметку страницы
    pw.println("<!DOCTYPE html>");
    pw.println("<html lang='ru'>");
    pw.println("<head>");
    pw.println("<meta charset='UTF-8'>");
    pw.println("<meta http-equiv='refresh' content='10'>");
    pw.println("<title>Сообщения</title>");
    pw.println("</head>");
    pw.println("<body>");

    // В обратном порядке записать в поток HTML-разметку для каждого сообщения
    for (int i = messages.size() - 1; i >= 0; i--) {
        ChatMessage aMessage = messages.get(i);
        pw.println("<div><strong>" + aMessage.getAuthor().getName()
                + "</strong>: " + aMessage.getMessage() + "</div>");
    }

    pw.println("</body></html>");
}

}
