package com.neodem.graphics.rays;

import org.assertj.core.data.Offset;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

/**
 * Created by Vincent Fumo (neodem@gmail.com)
 * Created on 8/12/20
 */
public class RayTest {

    private Ray ray;

    @Before
    public void setUp() throws Exception {
        ray = new Ray(new FloatingPoint(7.5f, 13.5f), 328);
    }

    @After
    public void tearDown() throws Exception {
        ray = null;
    }

    @Test
    public void constructorSetsCorrectQuadrant() {
        assertThat(ray.getQuadrant()).isEqualTo(Quadrant.UP_LEFT);
    }

    @Test
    public void intersectHorizontalShouldComputeCorrectFirstPoint() {
        List<FloatingPoint> floatingPoints = ray.intersectHorizontal(1);
        assertThat(floatingPoints.get(0).getX()).isCloseTo(7.3124347f, Offset.offset(.00001f));
        assertThat(floatingPoints.get(0).getY()).isCloseTo(13f, Offset.offset(.00001f));
    }

    @Test
    public void getDistanceToClosestHorizontalShouldBCorrectWhenUp() {
        float distanceToFirstHorizontal = ray.getDistanceToClosestHorizontal(13.5f, Orientation.UP);
        assertThat(distanceToFirstHorizontal).isEqualTo(0.5f);

        distanceToFirstHorizontal = ray.getDistanceToClosestHorizontal(13.2f, Orientation.UP);
        assertThat(distanceToFirstHorizontal).isCloseTo(0.2f, Offset.offset(.001f));

        distanceToFirstHorizontal = ray.getDistanceToClosestHorizontal(13.8f, Orientation.UP);
        assertThat(distanceToFirstHorizontal).isCloseTo(0.8f, Offset.offset(.001f));

    }

    @Test
    public void getDistanceToClosestHorizontalShouldBCorrectWhenDown() {
        float distanceToFirstHorizontal = ray.getDistanceToClosestHorizontal(13.5f, Orientation.DOWN);
        assertThat(distanceToFirstHorizontal).isEqualTo(0.5f);

        distanceToFirstHorizontal = ray.getDistanceToClosestHorizontal(13.2f, Orientation.DOWN);
        assertThat(distanceToFirstHorizontal).isCloseTo(0.8f, Offset.offset(.001f));

        distanceToFirstHorizontal = ray.getDistanceToClosestHorizontal(13.8f, Orientation.DOWN);
        assertThat(distanceToFirstHorizontal).isCloseTo(0.2f, Offset.offset(.001f));
    }

    @Test
    public void getDistanceToClosestVerticalShouldBCorrectWhenRight() {
        float distanceToFirstVertical = ray.getDistanceToClosestVertical(7.5f, Orientation.RIGHT);
        assertThat(distanceToFirstVertical).isEqualTo(0.5f);

        distanceToFirstVertical = ray.getDistanceToClosestVertical(7.2f, Orientation.RIGHT);
        assertThat(distanceToFirstVertical).isCloseTo(0.8f, Offset.offset(.001f));

        distanceToFirstVertical = ray.getDistanceToClosestVertical(7.8f, Orientation.RIGHT);
        assertThat(distanceToFirstVertical).isCloseTo(0.2f, Offset.offset(.001f));
    }

    @Test
    public void getDistanceToClosestVerticalShouldBCorrectWhenLeft() {
        float distanceToFirstVertical = ray.getDistanceToClosestVertical(7.5f, Orientation.LEFT);
        assertThat(distanceToFirstVertical).isEqualTo(0.5f);

        distanceToFirstVertical = ray.getDistanceToClosestVertical(7.2f,  Orientation.LEFT);
        assertThat(distanceToFirstVertical).isCloseTo(0.2f, Offset.offset(.001f));

        distanceToFirstVertical = ray.getDistanceToClosestVertical(7.8f,  Orientation.LEFT);
        assertThat(distanceToFirstVertical).isCloseTo(0.8f, Offset.offset(.001f));
    }
}