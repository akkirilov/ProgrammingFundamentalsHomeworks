<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Product of Three Numbers</title>
</head>
<body>
	<form>
		N 1: 	
		<input type="text" name="num1"/>
		N 2:
		<input type="text" name="num2"/>
		N 3:
		<input type="text" name="num3"/>
		<input type="submit" value="Send"/>
		<?php
			if (isset($_GET['num1']) && isset($_GET['num2']) && isset($_GET['num3'])) {
				$negatives;
				foreach ($_GET as $g) {
					if (intval($g) <= 0) {
						$negatives[] = $g;
					}
				}
				
				if (isset($negatives)) {
					if (in_array(0, $negatives) || count($negatives) % 2 == 0) {
						echo "<p>Positive</p>";
					}	else {
						echo "<p>Negative</p>";
					}
				}   else {
					echo "<p>Positive</p>";
				}
			}			
		?>
	</form>
</body>
</html>