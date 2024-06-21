#include <stdio.h>

int main() {
    int N, P;
    while (scanf("%d %d", &N, &P), N != 0 && P != 0) {
        int stacks[P][N]; // Array to store the stacks
        int sizes[P]; // Array to store the sizes of each stack
        int stack_with_box_1 = -1; // Index of the stack with box 1
        int position_of_box_1 = -1; // Position of box 1 in its stack

        // Reading the stacks
        for (int i = 0; i < P; i++) {
            scanf("%d", &sizes[i]);
            for (int j = 0; j < sizes[i]; j++) {
                scanf("%d", &stacks[i][j]);
                if (stacks[i][j] == 1) {
                    stack_with_box_1 = i;
                    position_of_box_1 = j;
                }
            }
        }

        // Calculate the number of boxes to remove
        int boxes_to_remove = sizes[stack_with_box_1] - position_of_box_1 - 1;
        if(boxes_to_remove == 1) 
        {
            printf("2\n");
        }
        else
        {
            printf("%d", boxes_to_remove);
        }
    }
    return 0;
}
