#include <cstdio>

int n, ans;
int chess[14][14];  // �ʱ�ȭ�� �̹� 0���� �Ǿ�����  

// line : 0 ~ n - 1
void recur(int line) {
    // ��������
    if (line == n) {
        ans++;
        return;
    }
    // line��򰡿��ٰ� queen�� ���ƺ���
    for (int i = 0 ; i < n ; i++) {
        if (chess[line][i] != -1) continue;
        chess[line][i] = line;
        // line�� �������ϱ� ��/��/��/��/�밢������ queen�� ���� ���ϰ� ó���Ѵ� 
        // ��/�� 
        for (int x = 0 ; x < n ; x++) {
            if (chess[line][x] == -1) {
                chess[line][x] = line;
            }
        }
        // ��
        for (int y = line ; y < n ; y++) {
            if (chess[y][i] == -1) {
                chess[y][i] = line;
            }
        }       
        // �밢��
        for (int y = line, x = i ; y < n && 0 <= x ; y++, x--) {
            if (chess[y][x] == -1) {
                chess[y][x] = line;
            }
        }
        for (int y = line, x = i ; y < n && x < n ; y++, x++) {
            if (chess[y][x] == -1) {
                chess[y][x] = line;
            }
        }

        // ���� �� queen�� ���ƺ���
        recur(line + 1);

        // ���� queen�� ó���� ������ �����.
        for (int x = 0 ; x < n ; x++) {
            if (chess[line][x] == line) {
                chess[line][x] = -1;
            }
        }
        // ��
        for (int y = line ; y < n ; y++) {
            if (chess[y][i] == line) {
                chess[y][i] = -1;
            }
        }       
        // �밢��
        for (int y = line, x = i ; y < n && 0 <= x ; y++, x--) {
            if (chess[y][x] == line) {
                chess[y][x] = -1;
            }
        }
        for (int y = line, x = i ; y < n && x < n ; y++, x++) {
            if (chess[y][x] == line) {
                chess[y][x] = -1;
            }
        }
    }
}

int main() {
    // array fill
    for (int i = 0 ; i < 14 ; i++) {
        for (int j = 0 ; j < 14 ; j++) {
            chess[i][j] = -1;
        }
    }
    scanf("%d", &n);
    // todo
    recur(0);
    printf("%d", ans);
}
