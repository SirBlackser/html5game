// base code is from Crafty.js Asteroids Demo
Crafty.init(800,600, document.getElementById('game'));
var player = Crafty.e('2D, DOM, Image, Controls')
    .attr({
        move: {
            left: false,
            right: false,
            up: false,
            down: false},
        xspeed: 0,
        yspeed: 0,
        decay: 0.995,
        x: 400,
        y: 300,
        w: 40,
        h: 40
    })
    .origin("center")
    // .color('#F00')
    .image("../images/ship.svg")
    .bind("KeyDown", function(e){
        //on keydown, set the move booleans
        if(e.keyCode === Crafty.keys.RIGHT_ARROW) {
            this.move.right = true;
        } else if(e.keyCode === Crafty.keys.LEFT_ARROW) {
            this.move.left = true;
        } else if(e.keyCode === Crafty.keys.UP_ARROW) {
            this.move.up = true;
        } else if (e.keyCode === Crafty.keys.SPACE) {
            console.log("Blast");
            //create a bullet entity
            Crafty.e("2D, DOM, Color")
                .attr({
                    x: this._x+20,
                    y: this._y+20,
                    w: 2,
                    h: 5,
                    rotation: this._rotation,
                    xspeed: 20 * Math.sin(this._rotation / 57.3),
                    yspeed: 20 * Math.cos(this._rotation / 57.3)
                })
                .color("rgb(0,0,0)")
                .bind("EnterFrame", function() {
                    this.x += this.xspeed;
                    this.y -= this.yspeed;

                    //destroy if it goes out of bounds
                    if(this._x > Crafty.viewport.width || this._x < 0 || this._y > Crafty.viewport.height || this._y < 0) {
                        this.destroy();
                    }
                });
        }
    }).bind("KeyUp", function(e) {
        //on key up, set the move booleans to false
        if(e.keyCode === Crafty.keys.RIGHT_ARROW) {
            this.move.right = false;
        } else if(e.keyCode === Crafty.keys.LEFT_ARROW) {
            this.move.left = false;
        } else if(e.keyCode === Crafty.keys.UP_ARROW) {
            this.move.up = false;
        }
    }).bind("EnterFrame", function() {
        if(this.move.right) this.rotation += 4;
        if(this.move.left) this.rotation -= 4;

        //acceleration and movement vector
        var vx = Math.sin(this._rotation * Math.PI / 180) * 0.3,
            vy = Math.cos(this._rotation * Math.PI / 180) * 0.3;

        //if the move up is true, increment the y/xspeeds
        if(this.move.up) {
            this.yspeed -= vy;
            this.xspeed += vx;
        } else {
            //if released, slow down the ship
            this.xspeed *= this.decay;
            this.yspeed *= this.decay;
        }

        //move the ship by the x and y speeds or movement vector
        this.x += this.xspeed;
        this.y += this.yspeed;

        //if ship goes out of bounds, put him back
        if(this._x > Crafty.viewport.width) {
            this.x = -64;
        }
        if(this._x < -64) {
            this.x =  Crafty.viewport.width;
        }
        if(this._y > Crafty.viewport.height) {
            this.y = -64;
        }
        if(this._y < -64) {
            this.y = Crafty.viewport.height;
        }

    });