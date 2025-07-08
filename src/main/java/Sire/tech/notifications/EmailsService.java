package Sire.tech.notifications;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


@Slf4j

@Component
public class EmailsService {

    private final MailpitClient mailpitClient;

    String senderEmail = "sire@mesnaissances.gn";
    String senderName = "Service Naissance";

    public EmailsService(MailpitClient mailpitClient) {
        this.mailpitClient = mailpitClient;
    }

    public void send(Map<String, String> parameters){

        String message = this.buildMessage(parameters);
        log.info("Le message est : {}", message);

        Map<String, Object> emailParameters = Map.of(
            "Subject", "Votre Code d'activation",
            "HTML", message,
            "text", message,
            "From", Map.of("email", senderEmail, "name", senderName),
            "To", List.of(Map.of("email", parameters.get("email"), "name", parameters.get("name")))
        );

        this.mailpitClient.send(emailParameters);



    }

    // cette configuration de freeMaker reste disponible pour tout autre projet il te permet de créer des templates
    //donc on peut juste adapter les variables utiliser dans le template

    private String buildMessage(Map<String, String> parameters){
        // Toutes ces configurations reste disponible pour une prochaine app
        Configuration configuration = new Configuration();

        configuration.setClassForTemplateLoading(this.getClass(), "/templates");
        configuration.setDefaultEncoding("UTF-8");
        configuration.setObjectWrapper(new DefaultObjectWrapper());

        try {
            Template template = configuration.getTemplate(parameters.get("template"));
            StringWriter stringWriter = new StringWriter();
            Map<String, String> templateParameters = Map.of(
                "name", parameters.get("name"),
                "code", parameters.get("code"));
            template.process(templateParameters, stringWriter);

            return stringWriter.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (TemplateException e) {
            throw new RuntimeException(e);
        }



    }

}
