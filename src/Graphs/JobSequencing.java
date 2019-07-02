package Graphs;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Mourya Balla
 * @project Practice
 * @CreatedOn 10-06-2019
 */

/*
https://www.techiedelight.com/job-sequencing-problem-deadlines/
o(n^2)
 */
public class JobSequencing {


    // data structure to store jobs info. Each job has an identifier,
// a deadline and profit associated with it
    static class Job
    {
        private int taskID, deadline, profit;

        public Job(int taskID, int deadline, int profit) {
            this.taskID = taskID;
            this.deadline = deadline;
            this.profit = profit;
        }

        public int getDeadline() {
            return deadline;
        }

        public int getProfit() {
            return profit;
        }

        public int getTaskID() {
            return taskID;
        }
    }

        // schedule jobs to maximize profit
        public static int scheduleJobs(List<Job> jobs, int T)
        {
            // stores maximum profit that can be earned by scheduling jobs
            int profit = 0;

            // array to store used and unused slots info
            int[] slot = new int[T];
            Arrays.fill(slot, -1);

            // consider each job in decreasing order of their profits
            for (Job job: jobs)
            {
                // search for next free slot and map the task to that slot
                for (int j = job.getDeadline() - 1; j >= 0; j--)
                {
                    if (j < T && slot[j] == -1)
                    {
                        slot[j] = job.getTaskID();
                        profit += job.getProfit();
                        break;
                    }
                }
            }

            // print the scheduled jobs
            System.out.println("The Scheduled jobs are - ");
            Arrays.stream(slot)			// Java 8 Streams
                    .filter(val -> val != -1)
                    .forEach(System.out::println);

            // return total profit that can be earned
            return profit;
        }

        public static void main(String[] args)
        {
            // List of given jobs. Each job has an identifier, a deadline and
            // profit associated with it
            List<Job> jobs = Arrays.asList(
                    new Job(1, 9, 15), new Job(2, 2, 2),
                    new Job(3, 5, 18), new Job(4, 7, 1),
                    new Job(5, 4, 25), new Job(6, 2, 20),
                    new Job(7, 5, 8), new Job(8, 7, 10),
                    new Job(9, 4, 12), new Job(10, 3, 5)
            );

            // stores maximum deadline that can be associated with a job
            final int T = 15;

            // arrange the jobs in decreasing order of their profits
            Collections.sort(jobs, (a, b) -> b.getProfit() - a.getProfit());

            // schedule jobs and calculate maximum profit
            System.out.println("\nTotal Profit is: " + scheduleJobs(jobs, T));
        }
    }

