import model.*;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Patient p = new Patient("09876543", "Ben Salah", "Ahmed",
                LocalDate.of(2001, 5, 14), "22123456", "ahmed@mail.com", "ASS-1001");

        MedecinRadiologue m = new MedecinRadiologue("MED01", "01234567",
                "Trabelsi", "Sami", Specialite.NEURORADIOLOGIE, 0.30);

        ManipulateurRadio manip = new ManipulateurRadio("MAN01", "07654321",
                "Gharbi", "Nour", 12.5);
        manip.ajouterHabilitation(Habilitation.IRM);

        System.out.println(p);
        System.out.println(m);
        System.out.println(manip);
        System.out.println("Peut faire IRM ? " + manip.possedeHabilitation(Habilitation.IRM));
        System.out.println("Peut faire Scanner ? " + manip.possedeHabilitation(Habilitation.SCANNER));
    }
}