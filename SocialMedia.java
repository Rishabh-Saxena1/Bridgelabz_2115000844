import java.util.*;

class User {
    int userId;
    String name;
    int age;
    List<Integer> friendIds;
    User next;

    User(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friendIds = new ArrayList<>();
        this.next = null;
    }
}

class SocialMedia {
    User head;

    void addUser(int userId, String name, int age) {
        User newUser = new User(userId, name, age);
        if (head == null) {
            head = newUser;
        } else {
            User temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newUser;
        }
    }

    User findUser(int userId) {
        User temp = head;
        while (temp != null) {
            if (temp.userId == userId) return temp;
            temp = temp.next;
        }
        return null;
    }

    void addFriend(int userId1, int userId2) {
        User user1 = findUser(userId1);
        User user2 = findUser(userId2);
        if (user1 != null && user2 != null && userId1 != userId2) {
            if (!user1.friendIds.contains(userId2)) user1.friendIds.add(userId2);
            if (!user2.friendIds.contains(userId1)) user2.friendIds.add(userId1);
        }
    }

    void removeFriend(int userId1, int userId2) {
        User user1 = findUser(userId1);
        User user2 = findUser(userId2);
        if (user1 != null && user2 != null) {
            user1.friendIds.remove(Integer.valueOf(userId2));
            user2.friendIds.remove(Integer.valueOf(userId1));
        }
    }

    List<Integer> findMutualFriends(int userId1, int userId2) {
        User user1 = findUser(userId1);
        User user2 = findUser(userId2);
        List<Integer> mutualFriends = new ArrayList<>();
        if (user1 != null && user2 != null) {
            for (int friendId : user1.friendIds) {
                if (user2.friendIds.contains(friendId)) {
                    mutualFriends.add(friendId);
                }
            }
        }
        return mutualFriends;
    }

    List<Integer> getAllFriends(int userId) {
        User user = findUser(userId);
        return user != null ? user.friendIds : new ArrayList<>();
    }

    User searchUser(String name) {
        User temp = head;
        while (temp != null) {
            if (temp.name.equalsIgnoreCase(name)) return temp;
            temp = temp.next;
        }
        return null;
    }

    int countFriends(int userId) {
        User user = findUser(userId);
        return user != null ? user.friendIds.size() : 0;
    }

    void displayUsers() {
        User temp = head;
        while (temp != null) {
            System.out.println("User ID: " + temp.userId + ", Name: " + temp.name + ", Age: " + temp.age);
            System.out.println("Friends: " + temp.friendIds);
            temp = temp.next;
        }
    }
    public static void main(String[] args) {
        SocialMedia obj = new SocialMedia();
        obj.addUser(1, "riya", 20);
        obj.addUser(2, "shaan", 21);
        obj.addUser(3, "rahul", 22);
        obj.addFriend(1, 2);
        obj.addFriend(1, 3);
        obj.displayUsers();
        System.out.println("Mutual Friends: " + obj.findMutualFriends(1, 2));
        obj.removeFriend(1, 2);
        obj.displayUsers();
    }
}
