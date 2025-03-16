package entity;
import java.io.Serializable;

public class ChatMessage implements Serializable{
    private static final long serialVersionUID = 1L;
    // Текст сообщения
    private String message;
    // Автор сообщения
    private ChatUser author;
    // Временная метка сообщения (в микросекундах)
    private long timestamp;
    public ChatMessage() {
        // Нужен для десериализации
    }

    public ChatMessage(String message, ChatUser author, long timestamp) {
        super();
        this.message = message;
        this.author = author;
        this.timestamp = timestamp;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public ChatUser getAuthor() {
        return author;
    }
    public void setAuthor(ChatUser author) {
        this.author = author;
    }
    public long getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
    @Override
    public String toString() {
        return "ChatMessage{message='" + message + "', author=" + author + ", timestamp=" + timestamp + "}";
    }
}
