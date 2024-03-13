/*
* Solution for lab exercise
*	Smooths input image
*	Displays both input and processed image.

* shows basic concepts
* will need to modularise the code for reuse
*/

// If using MAC, compile as follows:
//  gcc Edge.c -framework GLUT -framework OpenGL -framework Cocoa -o Edge

#ifdef _WIN32
    //define something for Windows (32-bit and 64-bit, this part is common)
    #include <gl/freeglut.h>        // For windows
#ifdef _WIN64
    //define something for Windows (64-bit only)
#endif
#elif __APPLE__
    #include <GLUT/glut.h>            // for Mac OS
#endif

#include <stdio.h>
#include <stdlib.h>

#define   MAXROW	200
#define   MAXCOL	320     /* handles 320x200 pixel images */

typedef 	unsigned char	pixel;       /* one byte (0 .. 255) for each pixel */
typedef	char	name[15];

name		image_file_name;

/* image buffers used for display */
pixel	image_buf[MAXROW*MAXCOL], out_image_buf[MAXROW*MAXCOL];
pixel 	image[MAXROW][MAXCOL], out_image[MAXROW][MAXCOL] ;   /* image arrays */
pixel	p;

name  	inf_name, outf_name;           /* strings to store file names */
FILE	*inf_handle, *outf_handle;    /*file handles created at file open */

int		charin;
int		r,c;

/*************************************************************************/
void	InputImage(void)
{
	printf("Enter the name of the input file  : ");
   gets(inf_name);

   /* try to open file for reading (r) in binary (b) mode */
   if  ((inf_handle = fopen(inf_name, "rb")) == NULL)  /* open failed */
    {
         puts("*** Can't open input file - please check file name typed!\n ");
         charin = getchar();
         exit(1);   /* terminate execution */
    }

   /* reaching this line of code means file opened successfully,
   now read file contents into image array */
  	for ( r = 0;  r < MAXROW; r++ )
      	for ( c = 0;  c < MAXCOL; c++)  {
            if((charin=fgetc(inf_handle))==EOF)   /* read failed */
            {
              printf("***File reading failed! \n");
              charin = getchar();
              exit(1);    /* terminate execution */
            }
            image[r][c] = charin;
         }

   /* reaching this line of code means all of file read successfully */
   printf("\nImage input completed!\n");
   fclose(inf_handle);    /* close input file  */
 }	/* end InputImage */
/*************************************************************************/


/*************************************************************************/
void	OutputImage(void)
{
 	printf("Enter the name of the output file : ");
	gets(outf_name);

   /* try to open file for writing (w) in binary (b) mode
   - create file if not existing already */
	outf_handle = fopen(outf_name, "wb");
   if (outf_handle == NULL) {
        puts("*** Can't open output file!");
        charin = getchar();
        exit(1);   /* terminate execution */
    }

   /* reaching this line of code means output file opened successfully,
   now write image pixels to file */
   for ( r = 0;  r < MAXROW; r++ )
      for ( c = 0;  c < MAXCOL; c++)  {
			fputc(out_image[r][c], outf_handle);
      }
	fclose(outf_handle);   /* close output file  */
   printf("\nImage output completed!\n");
}   /* end OutputImage */
/*************************************************************************/


/*************************************************************************/

void	WriteCaptions(void)
 {
   int	i;
   char	caption1[ ] = "INPUT_IMAGE";   // 11 chars  + null  char
   char	caption2[ ] = "EDGE_DETECTED";  // 12 chars + null char
   //char	caption1[ ] = "original image";   //
   //char	caption2[ ] = "copy";

   glColor3f(0.0, 0.0, 0.0);

   glRasterPos2i(154, 20);
   for (i=0; i< sizeof(caption1); i++)
   	glutBitmapCharacter(GLUT_BITMAP_9_BY_15, caption1[i]);

   glRasterPos2i(514, 20);
   for (i=0; i< sizeof(caption2); i++)
   	glutBitmapCharacter(GLUT_BITMAP_9_BY_15, caption2[i]);
 }

void	Display(void)
{
   int	offset;

/* flip image - 1st row becomes last - before calling glDrawPixels
to display original image*/
   offset = 0;
	for ( r = MAXROW-1;  r >= 0;  r-- )	{
      for ( c = 0;  c < MAXCOL; c++)  {
      	image_buf[MAXCOL*offset + c] =  image[r][c];
      }
      offset++;
	}

   /* flip image - 1st row becomes last - before calling glDrawPixels
   to display processed image*/
   offset = 0;
	for ( r = MAXROW-1;  r >= 0;  r-- )	{
      for ( c = 0;  c < MAXCOL; c++)  {
      	out_image_buf[MAXCOL*offset + c] =  out_image[r][c];
      }
      offset++;
	}

   glClear(GL_COLOR_BUFFER_BIT);

/* switch matrix mode  to 'projection' */
	glMatrixMode(GL_PROJECTION);
   glLoadIdentity();

/* set up an orthographic projection in 2D with a 760x280 viewing window  */
	gluOrtho2D(0.0,760.0, 0.0,280.0);

/* switch matrix mode back to 'model view' */
	glMatrixMode(GL_MODELVIEW);

   WriteCaptions();

/* set raster position for displaying image in graphics image buffer*/
   glRasterPos2i(40, 40);
/* load graphics image buffer with image from your own image buffer */
   glDrawPixels(MAXCOL, MAXROW, GL_LUMINANCE, GL_UNSIGNED_BYTE, image_buf); //image_buf

/* now do the same for displaying processed image to right of original image*/
   glRasterPos2i(400, 40);
   glDrawPixels(MAXCOL, MAXROW, GL_LUMINANCE, GL_UNSIGNED_BYTE, out_image_buf); // out_image_buf
   glFlush();
}
/*************************************************************************/

/*************************************************************************/
void  SetupDisplay(void)
{
   glutInitDisplayMode(GLUT_RGB|GLUT_DEPTH);

   glutInitWindowSize(760,280); /* 760 x 280 pixel graphics display window */

	glutInitWindowPosition(0,0); /* place window top left on display */

   glutCreateWindow("Image handler"); /* graphics window title */
	glClearColor(1.0, 1.0, 1.0, 1.0); /* set up to draw on white background */

   glutDisplayFunc(Display); /* register display callback function  */
}
 /*********************************************************/

/*************************************************************************/
void sobelFilter(pixel image[MAXROW][MAXCOL], pixel out_image[MAXROW][MAXCOL]){
    
    printf("The function is not implemented yet.\n");

}


/*********************************************************/
int	ProcessImage(void)
{
/* Smooth using 3x3 neighbourhood averaging.
	Pixels in top & bottom rows and leftmost and rightmost columns
   not processed  */
/*
	for ( r = 1;  r < MAXROW-1; r++ )
      for ( c = 1;  c < MAXCOL-1; c++)  {
         out_image[r][c] = ( image[r-1][c-1]
    								+ image[r-1][c] + image[r-1][c+1]
                           + image[r][c-1] + image[r][c]
    								+ image[r][c+1] + image[r+1][c-1]
                           + image[r+1][c] + image[r+1][c+1] ) / 9;
   }
}
*/

/* invert grey values */
/*
	for ( r = 0;  r < MAXROW; r++ )
      for ( c = 0;  c < MAXCOL; c++)  {
         p = image[r][c];
			out_image[r][c]=  abs(p - 255);
      }

*/
/* Reduce brightness */
/*
	for ( r = 0;  r < MAXROW; r++ )
      for ( c = 0;  c < MAXCOL; c++)  {
         p = image[r][c];
			out_image[r][c]=  abs(p - 128);
      }
*/

/*   Reduce brightness resolution to 4 levels (2 bits per pixel)*/
/*
for ( r = 0;  r < MAXROW; r++ )
      for ( c = 0;  c < MAXCOL; c++)  {
         p = image[r][c];
         if ( (p >= 0) && (p < 64) )
         	out_image[r][c]=  63;
         else if ( (p >= 64) && (p < 128) )
         	out_image[r][c]=  127;
         else if ( (p >= 128) && (p < 192) )
         	out_image[r][c]=  191;
         else if ( (p >= 192) && (p < 256) )
         	out_image[r][c]=  255;
      }
*/

  /* Sobel edge detector */
   sobelFilter(image, out_image);

 return 0;

}
/***********************************************************/


/*********************************************************/
void	main(int argc, char** argv)
{
   glutInit(&argc, argv);

	InputImage();
   ProcessImage();
   OutputImage();
   SetupDisplay();

   printf("\nPress Ctrl-c to end execution\n");
   glutMainLoop();


 }

