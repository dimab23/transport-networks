import model.Graph;

import java.util.Scanner;

/**
 * @author Dima B
 * @version problema3
 * @apiNote 15.05.2020
 */


public class Application {

    public static void main(String[] args) {
        int nrPeak;
        Graph graph = null;
        while (true) {

            Scanner scanner = new Scanner(System.in);
            System.out.println("\n\n\nAlegeti comanda");
            System.out.println("1 - Adauga un graph");
            System.out.println("2 - Reţele de transport (Ford -Fulkersson)");

            int command = scanner.nextInt();
            switch (command) {

                case 1:
                    System.out.print("Introduceti numarul de varfuri : ");
                    nrPeak = scanner.nextInt();

                    System.out.print("Introduceti numarul de arce : ");
                    int nrArcs = scanner.nextInt();
                    graph = new Graph(nrPeak);
                    for (int i = 0; i < nrArcs; i++) {
                        System.out.print("Introduceti start: ");
                        int start = scanner.nextInt();
                        System.out.print("Introduceti destinatia: ");
                        int end = scanner.nextInt();
                        System.out.print("Introduceti capacitatea: ");
                        float weight = scanner.nextFloat();

                        graph.addEdge(start, end, weight);
                    }
                    break;

                case 2:
                    assert graph != null;
                    graph.printGraph();

                    System.out.print("Ford-Fulkerson Max Flow: ");
                    System.out.println(new FordFulkerson().fordFulkerson(graph, 0, 7));
                    break;

                default:
                    System.exit(0);
            }
        }
    }
}