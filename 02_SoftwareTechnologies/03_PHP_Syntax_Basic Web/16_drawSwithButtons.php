<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" type="text/css" href="style.css">
    <title>Draw S With Buttons</title>
</head>
<body>
	<?php
		for ($i = 0; $i < 5; $i++) {
			for ($j = 0; $j < 5; $j++) {
				if ($i == 0 || $i == 4 || $j == 0) {
					echo "<button style=\"background-color: blue\">1</button>";
				}
				else {
					echo "<button>0</button>";
				}
			}
			echo "<br/>";
		}
		for ($i = 0; $i < 4; $i++) {
			for ($j = 0; $j < 5; $j++) {
				if ($i == 3 || $j == 4) {
					echo "<button style=\"background-color: blue\">1</button>";
				}
				else {
					echo "<button>0</button>";
				}
			}
			echo "<br/>";
		}
	?>
	</form>
</body>
</html>