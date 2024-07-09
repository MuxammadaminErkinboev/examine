package service;

import model.*;
import java.util.*;

public class GroupService implements BaseService<Group> {
    List<Group> groups = new ArrayList<>();
    @Override
    public Group add(Group group) {
        if (hasGroup(group.getName())) {
            return null;
        }
        groups.add(group);
        return group;
    }

    private boolean hasGroup(String groupName) {
        for (Group group : groups) {
            if(group.getName().equals(groupName)){
                return true;
            }
        }
        return false;
    }

    @Override
    public void delete(UUID id) {
        for (Group group: groups) {
            if (group.getId().equals(id)) {
                groups.remove(group);
            }
        }
    }

    @Override
    public Group update(UUID id, Group group) {
        for (int i = 0; i < groups.size(); i++) {
            if (groups.get(i).getId().equals(id)) {
                groups.set(i,group);
                return group;
            }
        }
        return null;
    }



    @Override
    public List<Group> list() {
        if(groups.isEmpty()) {
            return null;
        }
        return groups;
    }

    public Group isGroupByNumber(int x){
        int i = 1;
        for (Group group: groups){
            if (i == x){
                return group;
            }
            i++;
        }
        return null;
    }
}
