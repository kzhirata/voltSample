#!/usr/bin/perl

for(my $i = 1 ; $i < 1000001 ; $i++ ){
	$j = int(${i}/100) + 1;
	$day = sprintf('%02d',(${i}%31 + 1));
	print "${i},${j},タイトル${i},2014-01-${day} 00:00:00\n";
}
