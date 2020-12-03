package day023.chatting.server;

import java.io.Serializable;

public class DTO implements Serializable {

    int command;
    Object object;


    public void main() {

        DTO dto = new DTO();


        switch (dto.command) {
            case 1:
            {
                // 메세지로 간주하고 처리
                break;
            }
            case 2:
            {
                // 유저정보 수정으로 간주하고 처리
                break;
            }
            case 9:
            {
                // 채팅메세지
                break;
            }
        }

    }
}

