/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package de.hbarr.ai.dave

import de.hbarr.ai.dave.slurp.MnistReader
fun main(args: Array<String>) {
    var reader = MnistReader();
	reader.readMnistImage("src/main/resources/train-images.idx3-ubyte",2);
}
