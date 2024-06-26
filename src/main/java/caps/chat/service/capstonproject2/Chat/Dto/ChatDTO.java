package caps.chat.service.capstonproject2.Chat.Dto;


import lombok.*;

import java.sql.Timestamp;

@Data
@Builder
public class ChatDTO {
    // 메세지 타입 : 입장, 채팅
    public enum MessageType{
        ENTER, TALK
    }

    private MessageType type; // 메세지 타입
    private String roomId;    // 방 번호
    private String sender;    // 채팅을 보낸 사람
    private String message;   // 메세지
    private Timestamp time;      // 채팅 발송 시간
}
