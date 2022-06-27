/* 
Data preparation:
- regex substitution: ([LR]\d*) -> "$1"
*/  

public class c01_1 {
    public static void main(String[] args)
    {
        int x = 0;
        int y = 0;
        String[] data = new String[]{"R3", "L5", "R1", "R2", "L5", "R2", "R3", "L2", "L5", "R5", "L4", "L3", "R5", "L1", "R3", "R4", "R1", "L3", "R3", "L2", "L5", "L2", "R4", "R5", "R5", "L4", "L3", "L3", "R4", "R4", "R5", "L5", "L3", "R2", "R2", "L3", "L4", "L5", "R1", "R3", "L3", "R2", "L3", "R5", "L194", "L2", "L5", "R2", "R1", "R1", "L1", "L5", "L4", "R4", "R2", "R2", "L4", "L1", "R2", "R53", "R3", "L5", "R72", "R2", "L5", "R3", "L4", "R187", "L4", "L5", "L2", "R1", "R3", "R5", "L4", "L4", "R2", "R5", "L5", "L4", "L3", "R5", "L2", "R1", "R1", "R4", "L1", "R2", "L3", "R5", "L4", "R2", "L3", "R1", "L4", "R4", "L1", "L2", "R3", "L1", "L1", "R4", "R3", "L4", "R2", "R5", "L2", "L3", "L3", "L1", "R3", "R5", "R2", "R3", "R1", "R2", "L1", "L4", "L5", "L2", "R4", "R5", "L2", "R4", "R4", "L3", "R2", "R1", "L4", "R3", "L3", "L4", "L3", "L1", "R3", "L2", "R2", "L4", "L4", "L5", "R3", "R5", "R3", "L2", "R5", "L2", "L1", "L5", "L1", "R2", "R4", "L5", "R2", "L4", "L5", "L4", "L5", "L2", "L5", "L4", "R5", "R3", "R2", "R2", "L3", "R3", "L2", "L5"};
        int direction = 0; // 0=north,..., 3=west
        for (String elem : data)
        {
            // Change direction
            if (elem.charAt(0) == 'R') direction = (direction+1)%4;
            else direction = (--direction >= 0) ? direction%4 : 3; // % -> returns reminder, which can be negative
            //Move
            int value = Integer.parseInt(elem.substring(1));
            switch (direction)
            {
                case 0: y += value; break;
                case 1: x += value; break;
                case 2: y -= value; break;
                case 3: x -= value; break;
                default: break; 
            }
        }
        System.out.println("Distance is "+String.valueOf(Math.abs(x)+Math.abs(y)));
    }
}