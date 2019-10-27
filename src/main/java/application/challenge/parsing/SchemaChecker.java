package application.challenge.parsing;

import application.challenge.entity.Pulley;

import java.util.List;

public class SchemaChecker {

    public static void contactChecker(List<Pulley> pulleys) {

        for (int i = 0; i < pulleys.size() - 1; i++) {
            Pulley iPulley = pulleys.get(i);
            iPulley.setId(i + 1);
            for (int j = i + 1; j <= pulleys.size() - 1; j++) {
                Pulley jPulley = pulleys.get(j);
                jPulley.setId(j + 1);
                comparingTwoPulleys(iPulley, jPulley);
            }
        }
        for (Pulley p : pulleys) {
            contactCheck(p);
            lostMotionCheck(p);
            contactButNoMotion(p);
            correctPulley(p);
        }
    }

    private static void comparingTwoPulleys(Pulley p1, Pulley p2) {
        int upperContact = distanceMeter(p1, p2) - (p1.getRg() + p2.getRg());
        int bottomContact = distanceMeter(p1, p2) - (p1.getRd() - p2.getRd());
        if (upperContact < 0 || bottomContact < 0) {                            // Collision between wheels
            collision(p1, p2);
        }
        if (upperContact == 0 && bottomContact == 0) {                          // Clash between wheels
            clash(p1, p2);
        }
        if (upperContact == 0 && bottomContact > 0) {                           // Contact with a top part
            if (turningComarison(p1, p2)) {
                velocitySetterUpperContact(p1, p2);
            }
        } else if ((upperContact > 0 && bottomContact == 0)) {                  //Contact with a bottom part
            if (turningComarison(p1, p2)) {
                velocitySetterBottomContact(p1, p2);
            }
        }
    }

    private static int distanceMeter(Pulley p1, Pulley p2) {
        double distance = Math.sqrt((Math.pow(p1.getX() - p2.getX(), 2)) + Math.pow((p1.getY() - p2.getY()), 2));
        return (int) Math.round(distance);
    }

    private static boolean turningComarison(Pulley p1, Pulley p2) {
        p1.addContact(p2);
        p2.addContact(p1);
        if (p1.getN() != 0 && Integer.signum(p1.getN()) == Integer.signum(p2.getN())) {   // Both pulleys turning in the same direction
            nonConcurency(p1, p2);
            return false;
        } else if (p1.getN() != 0 && p1.getN() != -p2.getN() && p2.getN() != 0) {         // Pulleys turning in opposite direction but with different velocity
            nonConcurency(p1, p2);
            return false;
        }
        return true;
    }

    private static void velocitySetterUpperContact(Pulley p1, Pulley p2) {
        if (p1.getN() != 0) {
            p2.setN(-((p1.getN() * p1.getRg()) / p2.getRg()));
        } else if (p2.getN() != 0) {
            p1.setN(-((p2.getN() * p2.getRg()) / p1.getRg()));
        }
    }

    private static void velocitySetterBottomContact(Pulley p1, Pulley p2) {
        if (p1.getN() != 0) {
            p2.setN(-((p1.getN() * p1.getRd()) / p2.getRd()));
        } else if (p2.getN() != 0) {
            p1.setN(-((p2.getN() * p2.getRd()) / p1.getRd()));
        }
    }

    private static void collision(Pulley p1, Pulley p2) {
        p1.addAnnotation(" kolizja z krazkiem nr " + p2.getId());
        p2.addAnnotation(" kolizja z krazkiem nr " + p1.getId());
    }

    private static void clash(Pulley p1, Pulley p2) {
        p1.addAnnotation(" zakleszczenie z krazkiem nr " + p2.getId());
        p2.addAnnotation(" zakleszczenie z krazkiem nr " + p1.getId());
    }

    private static void nonConcurency(Pulley p1, Pulley p2) {
        p1.addAnnotation(" kolizyjne obroty z krazkiem nr " + p2.getId());
        p2.addAnnotation(" kolizyjne obroty z krazkiem nr " + p1.getId());
    }

    private static void contactCheck(Pulley p) {
        if (p.getContact().size() >= 3) {
            p.addAnnotation("Warning! Pulley has got contact with " + p.getContact().size() + " other pulleys");
        }
    }

    private static void lostMotionCheck(Pulley p) {
        if (p.getContact().size() == 0) {
            p.addAnnotation("Warning! Pulley " + p.getId() + " has no contact");
        }
    }

    private static void contactButNoMotion(Pulley p) {
        if (p.getContact().size() != 0 && p.getN() == 0) {
            p.addAnnotation("Pulley " + p.getId() + " has got contact with  pulleys: " + p.getContact() + " but has no motion");
        }
    }

    private static void correctPulley(Pulley p) {
        if (p.getAnnotations().isEmpty()) {
            p.addAnnotation("Pulley designed correct");
        }
    }
}
