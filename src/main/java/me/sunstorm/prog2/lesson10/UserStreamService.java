package me.sunstorm.prog2.lesson10;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UserStreamService {
    private final UserListProvider listProvider = new UserListProvider();

    public List<User> getFemaleUsers() {
        return listProvider.get()
                .stream()
                .filter(ExtendedUser.class::isInstance)
                .map(ExtendedUser.class::cast)
                .filter(u -> u.getGender() == Gender.FEMALE)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public List<User> getOldUsers() {
        return listProvider.get()
                .stream()
                .filter(ExtendedUser.class::isInstance)
                .map(ExtendedUser.class::cast)
                .filter(u -> u.getAge() > 30)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public List<String> getUserNamesFrom(String location) {
        return listProvider.get()
                .stream()
                .filter(ExtendedUser.class::isInstance)
                .map(ExtendedUser.class::cast)
                .filter(u -> u.getState().equals(location))
                .map(User::getUsername)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public List<String> getStates() {
        return listProvider.get()
                .stream()
                .filter(ExtendedUser.class::isInstance)
                .map(ExtendedUser.class::cast)
                .map(ExtendedUser::getState)
                .distinct()
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
