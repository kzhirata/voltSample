#!/usr/bin/perl

for(my $i = 0 ; $i < 1000000 ; $i++ ){
	$stateNo = $i % 100;
	$j = int($i/100);
	$population=${i}%1000;
	print "町${i},${stateNo},${stateNo},国${j},${population},${i}\n";
}
