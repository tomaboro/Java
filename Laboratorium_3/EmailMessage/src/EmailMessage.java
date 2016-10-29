import java.util.*;
import java.util.regex.Pattern;
import javax.activation.MimeType;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Created by Tomek on 2016-10-25.
 */

public class EmailMessage {
    private String from; //required (must be e-mail)
    private LinkedList<String> to; //required at least one (must be e-mail)
    private String subject; //optional
    private String content; //optional
    private String mimeType = "text/plain; charset=UTF-8";  // optional
    private LinkedList<String> cc; //optional
    private LinkedList<String> bcc; // optional

    private EmailMessage(Builder builder) {
        this.from = builder.from;
        this.to = builder.to;
        this.subject = builder.subject;
        this.content = builder.content;
        this.mimeType = builder.mimeType;
        this.cc = builder.cc;
        this.bcc = builder.bcc;
    }

    public String getFrom(){
        return from;
    }

    public LinkedList<String> getTo(){
        return to;
    }

    public String getSubject(){
        return subject;
    }

    public String getContent(){
        return content;
    }

    public String getMimeType(){
        return mimeType;
    }

    public LinkedList<String> getCc(){
        return cc;
    }

    public LinkedList<String> getBcc(){
        return bcc;
    }

    public void send(){
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        final String username = this.from;
        final String password = "Djgtu6qc9";

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            Message message = new MimeMessage(session);

            message.setFrom(new InternetAddress(this.from));

            ListIterator<String> toIterator = to.listIterator();
            while(toIterator.hasNext()){
                message.addRecipients(Message.RecipientType.TO, InternetAddress.parse(toIterator.next()));
            }

            ListIterator<String> ccIterator = cc.listIterator();
            while(ccIterator.hasNext()){
                message.addRecipients(Message.RecipientType.CC, InternetAddress.parse(ccIterator.next()));
            }

            ListIterator<String> bccIterator = bcc.listIterator();
            while(toIterator.hasNext()){
                message.addRecipients(Message.RecipientType.BCC, InternetAddress.parse(bccIterator.next()));
            }

            message.setSubject(this.subject);

            message.setContent(content, mimeType);

            //message.setText(this.content);


            Transport.send(message);

            System.out.println("Wiadomość wysłana pomyślnie....");
            System.out.println("FROM: \n" + from);
            System.out.println("TO: ");
            to.forEach(System.out::println);
            System.out.println("CC: ");
            cc.forEach(System.out::println);
            System.out.println("BCC: ");
            bcc.forEach(System.out::println);
            System.out.println("SUBJECT: \n" + subject);
            System.out.println("CONTENT: \n" + content);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }

    public static class Builder {
        private String from;
        private LinkedList<String> to = new LinkedList<String>();
        private String subject;
        private String content;
        private String mimeType = "text/plain; charset=UTF-8";
        private LinkedList<String> cc = new LinkedList<String>();
        private LinkedList<String> bcc = new LinkedList<String>();


        public Builder addTo(LinkedList<String> list){
            this.to = (LinkedList<String>) list.clone();
            return this;
        }
        public Builder addTo(String mail){
            this.to.add(mail);
            return this;
        }
        public Builder addFrom(String from){
            this.from = from;
            return this;
        }
        public Builder addSubject(String subject){
            this.subject = subject;
            return this;
        }
        public Builder addContent(String content){
            this.content = content;
            return this;
        }
        public Builder addMimeType(String mimeType){
            this.mimeType = mimeType;
            return this;
        }
        public Builder addCc(LinkedList<String> cc){
            this.cc = (LinkedList<String>) cc.clone();
            return this;
        }
        public Builder addCc(String cc){
            this.cc.add(cc);
            return this;
        }
        public Builder addBcc(LinkedList<String> bcc){
            this.bcc = (LinkedList<String>) bcc.clone();
            return this;
        }
        public Builder addBcc(String bcc){
            this.bcc.add(bcc);
            return this;
        }

        public static boolean checkMail(String mail){
            return Pattern.matches(".+@.+\\..{2,}", mail);
        }

        public EmailMessage build() throws IllegalStateException{
            EmailMessage mail = new EmailMessage(this);
            if(this.from == null){
                throw new IllegalStateException("Pole 'FROM' jest puste");
            }
            if(!checkMail(this.from)){
                throw new IllegalStateException("Pole 'FROM' nie zawiera prawiodłowego adresu emmail");
            }
            if(this.to.size()==0){
                throw new IllegalStateException("Pole 'TO' jest puste");
            }
            ListIterator<String> toIterator = to.listIterator();
            while(toIterator.hasNext()){
                if(!checkMail(toIterator.next())){
                    throw new IllegalStateException("Jedno z pól 'TO' nie zwiera prawidłowego adresu email");
                }
            }
            ListIterator<String> ccIterator = cc.listIterator();
            while(toIterator.hasNext()){
                if(!checkMail(ccIterator.next())){
                    throw new IllegalStateException("Jedno z pól 'CC' nie zwiera prawidłowego adresu email");
                }
            }
            ListIterator<String> bccIterator = bcc.listIterator();
            while(bccIterator.hasNext()){
                if(!checkMail(bccIterator.next())){
                    throw new IllegalStateException("Jedno z pól 'BCC' nie zwiera prawidłowego adresu email");
                }
            }
            return mail;
        }
    }
}
