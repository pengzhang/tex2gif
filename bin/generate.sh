#!/bin/bash
generate(){
	DIR=/home/jbl/latex_gif
	cd $DIR
	$DIR/textogif $1
}
generate $1
