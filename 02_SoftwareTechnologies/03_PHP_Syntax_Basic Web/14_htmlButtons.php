<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" type="text/css" href="style.css">
    <title>HTML Buttons</title>
</head>
<body>
	<form>
		N:
		<input type="text" name="num" />
		<input type="submit" />
		<?php
			$num = intval($_GET['num']);
			for ($i = 1; $i <= $num; $i++) {
				echo "<button>{$i}</button>";
			}
		?>
	</form>
</body>
</html>