#!/usr/bin/perl

for(my $i = 1 ; $i < 100001 ; $i++ ){
	$lccode = "L0" . sprintf('%06d', $i);
	print "${i},名字${i},名前${i},カナミョウジ${i},カナナマエ${i},${lccode}\n";
}
