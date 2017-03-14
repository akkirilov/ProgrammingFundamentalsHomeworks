<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Tribonacci Sequence</title>
</head>
<body>
	<form>
		Number:
		<input type="text" name="num" />
		<input type="submit" />
	</form>
	<?php
		if (!isset($_GET['num']) || $_GET['num'] == ""){
			return;
		}
		
		$num = intval($_GET['num']);
		if ($num < 4) {
			$fibs = [1, 1, 2];
			echo "<p>";
			for ($i = 0; $i < $num; $i++) {
				echo "{$fibs[$i]} ";
			}
			echo "</p>";
			return;
		}
		
		$fibA = 1;
		$fibB = 1;
		$fibC = 2;
		$fibD;
		echo "<p>{$fibA} {$fibB} {$fibC} ";
		
		for ($i = 3; $i < $num; $i++) {
			$fibD = $fibA + $fibB + $fibC;
			echo $fibD . " ";
			$temp = $fibB;
			$fibA = $temp;
			$fibB = $fibC;
			$fibC = $fibD;
		}
		echo "</p>";
	?>
</body>
</html>