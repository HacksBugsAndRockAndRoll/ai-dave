package de.hbarr.ai.dave.slurp

import java.io.File

/**
 TRAINING SET LABEL FILE (train-labels-idx1-ubyte):
[offset] [type]          [value]          [description]
0000     32 bit integer  0x00000801(2049) magic number (MSB first)
0004     32 bit integer  60000            number of items
0008     unsigned byte   ??               label
0009     unsigned byte   ??               label
........
xxxx     unsigned byte   ??               label
The labels values are 0 to 9.

TRAINING SET IMAGE FILE (train-images-idx3-ubyte):
[offset] [type]          [value]          [description]
0000     32 bit integer  0x00000803(2051) magic number
0004     32 bit integer  60000            number of images
0008     32 bit integer  28               number of rows
0012     32 bit integer  28               number of columns
0016     unsigned byte   ??               pixel
0017     unsigned byte   ??               pixel
........
xxxx     unsigned byte   ??               pixel
Pixels are organized row-wise. Pixel values are 0 to 255. 0 means background (white), 255 means foreground (black).

TEST SET LABEL FILE (t10k-labels-idx1-ubyte):
[offset] [type]          [value]          [description]
0000     32 bit integer  0x00000801(2049) magic number (MSB first)
0004     32 bit integer  10000            number of items
0008     unsigned byte   ??               label
0009     unsigned byte   ??               label
........
xxxx     unsigned byte   ??               label
The labels values are 0 to 9.

TEST SET IMAGE FILE (t10k-images-idx3-ubyte):
[offset] [type]          [value]          [description]
0000     32 bit integer  0x00000803(2051) magic number
0004     32 bit integer  10000            number of images
0008     32 bit integer  28               number of rows
0012     32 bit integer  28               number of columns
0016     unsigned byte   ??               pixel
0017     unsigned byte   ??               pixel
........
xxxx     unsigned byte   ??               pixel
Pixels are organized row-wise. Pixel values are 0 to 255. 0 means background (white), 255 means foreground (black).

 r1r1r1r1 r2r2r2r2 r3r3r3r3 r4r4r4r4 r5r5r5r5

 **/
class MnistReader {
	
	fun readMnistImage(fileName:String ,index: Int) {
		var headerBytes = 4*4;
		var rows = 28;
		var cols = 28;

		var imageBytes = rows * cols;

		var input = File(fileName).readBytes().asUByteArray().drop(headerBytes-1);

		for (img in index*imageBytes until input.size step imageBytes) {
			var image = input.slice(img..img+imageBytes-1).chunked(cols);
			image.forEach{ row ->
				row.forEach{ px ->
					if(px > 127u)
						print("▮▮");
					else
						print("▯▯");
				}
				println();
			}
			break;
		}
	}
}

