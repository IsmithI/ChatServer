package ua.kiev.prog.JSON;

import ua.kiev.prog.Entities.Message;

import java.util.ArrayList;
import java.util.List;

public class JsonMessages {
    private final List<Message> list;

    public JsonMessages(List<Message> sourceList, int fromIndex) {
        this.list = new ArrayList<>();
        for (int i = fromIndex; i < sourceList.size(); i++)
            list.add(sourceList.get(i));
    }
}
