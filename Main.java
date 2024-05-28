public class Main {
    public static void main(String[] args) {
        Youtuber youtuber = new Youtuber("Tech Guru", "tech@guru.com");
        User user = new User("Rajesh", "Rajesh@gmail.com");

        Channel channel = youtuber.createChannel("Tech Tips");
        channel.subscribe(user);

        Video video = new Video("What are LLM's", "This video explains differnet components of a LLM model.");
        channel.uploadVideo(video);
    }

    public static abstract class Person {
        private String name;
        private String email;

        public Person(String name, String email) {
            this.name = name;
            this.email = email;
        }

        public String getName() {
            return name;
        }

        public String getEmail() {
            return email;
        }
    }

    public static class User extends Person {
        public User(String name, String email) {
            super(name, email);
        }

        public void receiveNotification(String message) {
            System.out.println("Notification for " + getName() + ": " + message);
        }
    }

    public static class Youtuber extends Person {
        public Youtuber(String name, String email) {
            super(name, email);
        }

        public Channel createChannel(String channelName) {
            return new Channel(channelName, this);
        }
    }

    public static class Channel {
        private String name;
        private Youtuber owner;
        private java.util.List<User> subscribers = new java.util.ArrayList<>();
        private java.util.List<Video> videos = new java.util.ArrayList<>();

        public Channel(String name, Youtuber owner) {
            this.name = name;
            this.owner = owner;
        }

        public void subscribe(User user) {
            subscribers.add(user);
        }

        public void uploadVideo(Video video) {
            videos.add(video);
            notifySubscribers("New video posted: " + video.getTitle());
        }

        private void notifySubscribers(String message) {
            for (User user : subscribers) {
                user.receiveNotification(message);
            }
        }
    }

    public static class Video {
        private String title;
        private String description;

        public Video(String title, String description) {
            this.title = title;
            this.description = description;
        }

        public String getTitle() {
            return title;
        }
    }
}
