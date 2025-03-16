package servlet;

import entity.ChatMessage;
import entity.ChatUser;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class ChatServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    // Карта текущих пользователей
    private static final String USERS_FILE = "D:/Java/University/Term2/Lab8/users.dat"; // Укажите путь
    private static final String MESSAGES_FILE = "D:/Java/University/Term2/Lab8/messages.dat";

    protected HashMap<String, ChatUser> activeUsers;
    // Список сообщений чата
    protected ArrayList<ChatMessage> messages;
    @SuppressWarnings("unchecked")
    public void init() throws ServletException {
// Вызвать унаследованную от HttpServlet версию init()
        super.init();
// Извлечь из контекста карту пользователей и список сообщений
        activeUsers = (HashMap<String, ChatUser>)
                getServletContext().getAttribute("activeUsers");
        messages = (ArrayList<ChatMessage>)
                getServletContext().getAttribute("messages");
// Если карта пользователей не определена ...
        if (activeUsers==null) {
// Создать новую карту
            activeUsers = new HashMap<String, ChatUser>();
// Поместить еѐ в контекст сервлета,
            activeUsers = loadUsers();
// чтобы другие сервлеты могли до него добраться
            getServletContext().setAttribute("activeUsers",
                    activeUsers);
        }
// Если список сообщений не определѐн ...
        if (messages==null) {
// Создать новый список
            messages = new ArrayList<ChatMessage>(100);
// Поместить его в контекст сервлета,
// чтобы другие сервлеты могли до него добрать
            messages = loadMessages();
            getServletContext().setAttribute("messages", messages);
        }
    }
    @Override
    public void destroy() {
        super.destroy();
        saveUsers();
        saveMessages();
    }

    private void saveUsers() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(USERS_FILE))) {
            out.writeObject(activeUsers);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private HashMap<String, ChatUser> loadUsers() {
        File file = new File(USERS_FILE);
        if (!file.exists()) return new HashMap<>();
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            return (HashMap<String, ChatUser>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new HashMap<>();
        }
    }

    private void saveMessages() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(MESSAGES_FILE))) {
            out.writeObject(messages);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private ArrayList<ChatMessage> loadMessages() {
        File file = new File(MESSAGES_FILE);
        if (!file.exists()) return new ArrayList<>();
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            return (ArrayList<ChatMessage>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
