#include<iostream>
#include<math.h>
using namespace std;

int label = 0;
int checkerBoard[256][256];


// placing the triomino
void fillTile(int x1, int y1, int x2, int y2, int x3, int y3)
{
	++label;
	checkerBoard[x1][y1] = label;
	checkerBoard[x2][y2] = label;
	checkerBoard[x3][y3] = label;
}

void tiling(int n, int x, int y)
{
	
	int r;
	int c;

	if (n == 2) {
		++label;
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				if (checkerBoard[x+i][y+j] == 0) {
					checkerBoard[x+i][y+j] = label;
				}
			}
		}
		return;
	}

	// missing tile coordinates
	for (int i = x; i < x+n; ++i) {
		for (int j = y; j < y+n; ++j) {
			if (checkerBoard[i][j] != 0)
			{
				r=i;
				c=j;
			}
		}
	}

	// missing tile is 1st quadrant
	if (r < x+n/2 && c < y+n/2)
		fillTile(x+n/2, y+(n/2)-1, x+n/2, y+n/2, x+n/2-1, y+n/2);

	// missing tile is in 3rd quadrant
	else if (r >= x+n/2 && c < y+n/2)
		fillTile(x+(n/2)-1, y+(n/2), x+(n/2), y+n/2, x+(n/2)-1, y+(n/2)-1);

	// missing tile is in 2nd quadrant
	else if (r < x+n/2 && c >= y+n/2)
		fillTile(x+n/2, y+(n/2)-1, x+n/2, y+n/2, x+n/2-1, y+n/2-1);

	// missing tile is in 4th quadrant
	else if (r >= x+n/2 && c >= y+n/2)
		fillTile(x+(n/2)-1, y+(n/2), x+(n/2), y+(n/2)-1, x+(n/2)-1, y+(n/2)-1);

	// dividing it again in 4 quadrants
	tiling(n/2, x, y+n/2);
	tiling(n/2, x, y);
	tiling(n/2, x+n/2, y);
	tiling(n/2, x+n/2, y+n/2);

	
}


int main() // main driver code
{
	int n;
	int x;
	int y;
	
	// board size
	cout<<"Enter n: ";
	cin>>n;
	int sz = pow(2,n);

	// enter coordinates of missing tile
	cout<<"Enter missing coordinate(space separated integers): ";
	cin>>x>>y;


	for (int i = 0; i < 256; ++i)
		for (int j = 0; j < 256; ++j)
			checkerBoard[i][j]=0;

	checkerBoard[x][y] = -1; // set missing tile to zero


	tiling(sz, 0, 0); // tiling the board
	
	// output
	for (int i = 0; i < sz; ++i) {
		for (int j = 0; j < sz; ++j)
			cout << checkerBoard[i][j] << " \t";
		cout << "\n";
	}
}

